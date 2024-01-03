import { BrowserRouter } from 'react-router-dom';
import './App.css';
import Layout from './component/Layout';

function App() {
  return (
    <BrowserRouter>
      <Layout color='#fff'/>
    </BrowserRouter>
  );
}

export default App;