import './App.css';

function KhHeader(){
  return<h1>해더 ㅋㅋㅋ</h1>
}
function KhNavi(){
  return <div className="naviWrap">
    <KhNaviItem />
    <KhNaviItem />
    <KhNaviItem />
    <KhNaviItem />
  </div>;
}
/*<h1>네비 ㅋㅋㅋ</h1>*/
function KhNaviItem(){
  return <span>공지사항</span>
}

function App() {
  return (
    <>
      <KhHeader />
      <KhNavi />
    </>

  );
}

export default App;
