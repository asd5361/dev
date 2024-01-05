import './App.css';
import Hearder from './component/Hearder';
import Main from './component/Main';
import { KhMemoryProvider } from './context/KhContext';


function App() {
  
  return (
  <>
    <KhMemoryProvider>
      <Hearder />
      <Main />
    </KhMemoryProvider>
  </>
  );
}

export default App;
