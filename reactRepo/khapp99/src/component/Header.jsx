import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledHeaderDiv = styled.div`

    width: 100%;
    height: 100%;
    display:  grid;
    grid-template-columns: 1fr 3fr 1fr;
    grid-template-rows: 1fr;
    & >.logoArea{
        background-image: url('https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/LEGO_logo.svg/2048px-LEGO_logo.svg.png');
        background-repeat: no-repeat;
        background-size: 30%;
        background-position: center center;
        width: 100%;
    }
`;
// MEMBER > login 관련
    const StyledLoginAreaDiv = styled.div`
        width: 100%;
        height: 100%;
        & > form {
            width: 100%;
            height: 100%;
            display:  grid;
            grid-template-columns: 1fr 1fr;
            grid-template-rows: repeat(3, 1fr);
            & > input:nth-child(1),        
            & > input:nth-child(2){
                grid-column: span 2;
            }        
        }
    `;

const Header = () => {
    
    const navigate = useNavigate();

    // const [loginMemberVo,setLoginMemberVo] = useState(JSON.parse(sessionStorage.getItem("loginMemberVo")));
    
    const [loginMemberVo,setLoginMemberVo] = useState(null);
    
    const handleClickLogo = () => {
        navigate('/');
    };
    const handleClickJoin = () => {
        navigate('/member/join');
    };
    const [vo,setVo] = useState();
    
    const handleInputChange = (event) => {
        const {value,name} = event.target;
        setVo({
            ...vo,
            [name] : value
        });
    }

    const handleClickLogin = (event) => {

        event.preventDefault();

        fetch("http://127.0.0.1:8888/app/rest/member/login",{
            method : "POST",
            headers : {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify(vo),
        })
        .then( (resp) => { return resp.json() } )
        .then( (data)=>{
            console.log(data);
            if(data.msg === "good"){
                alert("로그인 성공");
                // setLoginMemberVo(data.loginMember);
                sessionStorage.setItem("loginMemberVo",JSON.stringify(data.loginMember));
                const jsonStr = sessionStorage.getItem("loginMemberVo");
                const sessionLoginMemberVo = JSON.parse(jsonStr);
                setLoginMemberVo(sessionLoginMemberVo);
            }else{
                alert("로그인 실패");
            }
        })
        .catch( (e)=>{ console.log(e);} )
        .finally(()=>{  })
        ;
    };
    


    return (
        <StyledHeaderDiv>
            <div></div>
            <div className='logoArea' onClick={handleClickLogo}></div>
            { 
                loginMemberVo === null
                ?  
                <StyledLoginAreaDiv>
                    <form onSubmit={handleClickLogin} >
                        <input type="text" name='id' onChange={handleInputChange} placeholder='아이디'/>
                        <input type="password" name='pwd'  onChange={handleInputChange} placeholder='패스워드'/>
                        <input type="button" value="회원가입" onClick={handleClickJoin}/>
                        <input type="submit" value="로그인" />
                    </form>
                </StyledLoginAreaDiv>
                : 
                <div>
                    <h3>{loginMemberVo.nick}님 환영합니다.</h3>
                    <button onClick={ ()=>{ sessionStorage.removeItem("loginMemberVo"); setLoginMemberVo(null)
                } }>로그아웃</button>
                </div>
            }
        </StyledHeaderDiv>
    );
};

export default Header;