import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StlyedBoardWriteDiv = styled.div`
    width: 100%;
    height: 100%;
    & > form{
        width: 100%;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
`;

const BoardWrite = () => {

    const str = sessionStorage.getItem("loginMemberVo");
    const vo = JSON.parse(str);
    const writerNo = vo.no;
    
    const [inputBoardVo,setInputBoardVo] = useState({

        //작성자 번호 삽입 key value가 동일하면 이렇게 작성해도 된다.
        // writerNo : JSON.parse(sessionStorage.getItem("loginMemberVo")).no,
        // (동일) "writerNo" : writerNo,
        writerNo,
    });
    const navigator = useNavigate();

    const handleSubmit = (event) => {
        event.preventDefault();

        fetch("http://127.0.0.1:8888/app/api/board/write",{
            method : "POST",
            headers : {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify(inputBoardVo),
        })
        .then( resp => resp.json() )
        .then((data)=>{
            if(data.msg === "good"){
                alert("게시글 작성 성공!");
                navigator("/board/list")
            }else{
                alert("게시글 작성 실패!");
            }

        })
        ;
    }

    const handleChangeInput = (event) => {

        const {name,value} = event.target;
        
        setInputBoardVo({
            ...inputBoardVo,
            [name] : value,
        });

    
    }

    return (
        <StlyedBoardWriteDiv>
            <form onSubmit={handleSubmit}>
                <table>
                    <tbody>
                        <tr>
                            <td>제목</td>
                            <td><input type='text' name='title' onChange={handleChangeInput} /></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea type='text' name='content' onChange={handleChangeInput}></textarea></td>
                        </tr>
                        <tr>
                            <td colSpan={2}><input type='submit' value='작성하기' /></td>
                        </tr>
                        
                    </tbody>
                </table>
            </form>
        </StlyedBoardWriteDiv>
    );
};

export default BoardWrite;