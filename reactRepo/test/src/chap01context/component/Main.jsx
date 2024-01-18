import { CntContextProvider } from './CntContext';
import DisplayCnt from './DisplayCnt';
import PlusCnt from './PlusCnt';
import MinusCnt from './MinusCnt';
const Main = () => {
    
// 함수를 <CntContextProvider> 모양으로 만들 수 있다.
// <CntContextProvider> 태그 사이에 있는 값은 props안에 담긴다.

    return (<>
            <CntContextProvider>
                <DisplayCnt />
                <PlusCnt />
                <MinusCnt />                
            </CntContextProvider>
    </>);
};

export default Main;