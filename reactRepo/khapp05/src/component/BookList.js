
export default function BookList(){
    const book1 = {
        title : "해리포터1",
        writer: "홍길동1"
    };
    const book2 = {
        title : "해리포터2",
        writer: "홍길동2"
    };
    const book3 = {
        title : "해리포터3",
        writer: "홍길동3"
    };
    const bookList = [book1,book2,book3];
    return (<>
        <div className="bookListWrap">
            <table>
                <thead>
                    <tr>
                        <th>제목</th>
                        <th>저자</th>
                    </tr>
                </thead>
                <tbody>
                    {/* 배열 반복문 */}
                { bookList.map((x)=>{
                    return (
                        <tr>
                            <td>{x.title}</td>
                            <td>{x.writer}</td>
                        </tr>
                        );
                    }) }
                    <tr>
                        <td>{bookList[0].title}</td>
                        <td>{bookList[0].writer}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </>)
}