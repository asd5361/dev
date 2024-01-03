import React from 'react';
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

    const handleClickJoin = () => {
        navigate('/member/join');
    };

    const handleClickLogo = () => {
        navigate('/');
    };


    return (
        <StyledHeaderDiv>
            <div></div>
            <div className='logoArea' onClick={handleClickLogo}></div>
            <StyledLoginAreaDiv>
                <form action='/member/login' method='post'>
                    <input type="text" name='id' placeholder='아이디'/>
                    <input type="password" name='pwd' placeholder='패스워드'/>
                    <input type="button" value="회원가입" onClick={handleClickJoin}/>
                    <input type="submit" value="로그인" />
                </form>
            </StyledLoginAreaDiv>
        </StyledHeaderDiv>
    );
};

export default Header;