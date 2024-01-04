import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledBoardListDiv = styled.div`
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column; //y축 방향으로 변경
    & > table {
        width: 80%;
        height: 80%;
        border: 3px solid #000;
        
    }
    & button{
        width: 30%;
        font-size: 1.2rem;
    }
`;


const BoardList = () => {

    console.log("BoardList 컴포넌트 렌더링~~");

    const navigate = useNavigate();

    //fetch를 이용해서 데이터 준비
    let [boardVoList, setBoardVoList] = useState([]);
    const loadBoardVoList = () => {
        fetch('http://127.0.0.1:8888/app/api/board/list')
        .then( resp => resp.json() )
        .then( (data) => {setBoardVoList(data);})
        ;
    }
    useEffect(()=>{
        loadBoardVoList();
    },[]);

    
    // const boardVoList = [];
    // boardVoList[0] = {
    //     no : '1',
    //     title : 'title01',
    //     write : 'writer01',
    //     hit : '777',
    //     enrollDate: new Date().toString()
    // };
    // boardVoList[1] = {
    //     no : '2',
    //     title : 'title02',
    //     write : 'writer02',
    //     hit : '888',
    //     enrollDate: new Date().toString()
    // };
    // boardVoList[2] = {
    //     no : '3',
    //     title : 'title03',
    //     write : 'writer03',
    //     hit : '999',
    //     enrollDate: new Date().toString()
    // };

    // for (let index = 0; index < boardVoList.length; index++) {
    //     console.log(boardVoList[index]);
    //     console.log(boardVoList[index].no);
    // }
    // boardVoList.forEach(vo => {
    //     console.log(vo);
    // });
    // const fff = boardVoList.map( (x)=>{
    //     console.log(x);
    //     return (<tr>
    //         <td>{x.no}</td>
    //         <td>{x.title}</td>
    //         <td>{x.write}</td>
    //         <td>{x.hit}</td>
    //         <td>{x.enrollDate}</td>
    //     </tr>)
    //     ;
    // });
    // console.log(fff);
    
    
    return (
        <StyledBoardListDiv>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>작성일시</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        boardVoList.length === 0
                        ?
                        <h1>로딩중..</h1>
                        :
                        boardVoList.map( vo=>
                            (<tr key={vo.no}>
                                <td>{vo.no}</td>
                                <td>{vo.title}</td>
                                <td>{vo.writerNo}</td>
                                <td>{vo.hit}</td>
                                <td>{vo.enrollDate}</td>
                            </tr>)
                        )
                    }
                </tbody>
            </table>
                
            <button onClick={()=>{
                navigate("/board/write");
            }}>게시글 작성하기</button>
        
        </StyledBoardListDiv>
    );
};

export default BoardList;