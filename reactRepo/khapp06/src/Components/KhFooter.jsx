import React from "react";
const KhFooter = () => {
    const x = {

        width: '100vw',
        height : '10vh',
        backgroundColor : 'black',
        color : '#fff',
        display : 'grid',
        gridTemplateRows : '1fr',
        gridTemplateColumns : '1fr 3fr 1fr',
        
    }

    return (<>
        <footer style={x}>
            <div>빈칸</div>
            <div>설명</div>
            <div>빈칸</div>
        </footer>
    </>);
}
export default KhFooter;