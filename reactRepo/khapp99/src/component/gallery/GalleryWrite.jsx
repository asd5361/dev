import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
const StyledGalleryWriteDiv = styled.div`

width: 100%;
height: 100%;
background-color: gray;
display: flex;
flex-direction: column;
justify-content: space-evenly;
align-items: center;
`;

const GalleryWrite = () => {

    const [title,setTitle] = useState();
    const [fileObj,setFileObj] = useState();

    const handleChangeTitle = (e) => {
            setTitle(e.target.value);
    }

    const handleChangeFile = (e) =>{
            setFileObj(e.target.files[0]);
    }

    const navigator = useNavigate();

    const handleSubmit = (event) => {
        event.preventDefault();

        const fd = new FormData();
        fd.append("title",title);
        fd.append("f",fileObj);
        fd.append("writerNo",1); //sessionStroage.getItem("loginMember") 파싱

        fetch("http://127.0.0.1:8888/app/api/gallery",{
            method : "POST",
            // headers : {}, 
            body : fd,
        })
        .then(resp => resp.json())
        .then(data =>{
            if(data.msg === "good"){
                alert("갤러리 작성 완료");
                navigator("/gallery/list");
            }else{
                alert("갤러리 작성 실패");
            }
        })
        ;
    };

    return (
        <StyledGalleryWriteDiv>
            <form onSubmit={handleSubmit} >
                <input type='text' onChange={handleChangeTitle} name='title' placeholder='제목 입력'/>
                <input type='file' onChange={handleChangeFile} name='f' />
                <input type='submit' value='작성하기'/>
            </form>
        </StyledGalleryWriteDiv>
    );
};

export default GalleryWrite;