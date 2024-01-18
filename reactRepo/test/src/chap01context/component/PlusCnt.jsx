import { useCntContext } from './CntContext';

const PlusCnt = () => {

    let {cnt, setCnt} = useCntContext(); //해당 컨텍스트에서 value 를 가져온다

    return (
        <div onClick={()=>{
            setCnt(cnt +1);
        }}>플러스 카운트</div>
    );
};

export default PlusCnt;