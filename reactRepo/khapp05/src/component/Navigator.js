import {Link} from "react-router-dom";

export default function Navigator(){
    return(<>
        <div>
            <div><Link to="/book/list">도서 목록조회</Link></div>
            <div><Link to="/book/insert">도서 추가하기</Link></div>
        </div>
    </>);
}