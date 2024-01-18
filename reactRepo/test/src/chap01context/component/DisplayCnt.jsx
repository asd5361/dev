import { useCntContext } from './CntContext';

const DisplayCnt = () => {

    const value = useCntContext(); //해당 컨텍스트에서 value 를 가져온다

    return (
        <div onClick={()=>{ 
            console.log("디스플레이 카운트가 알고있는 value ::: ",value);
         }}>디스플레이 카운트 : {value.cnt}</div>
    );
};

export default DisplayCnt;