import logo from './logo.svg';
import './App.css';

export function KhComponent(){
  return <h1>안녕</h1>;
}

export function KhComponent2(){
  return <h1>잘가</h1>;
}
export function KhComponentAll(){
  return <div>
    <KhComponent/>
    <KhComponent2/>
  </div>;
}
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
