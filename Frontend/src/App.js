import './App.css';
import DataTable from './components/DataTable';
import handleDeleteAll from './components/DataTable';
import x from "./Group 20399.svg"
import y from "./HRC.svg"
import Footer from './components/Footer';



function App() {
  
  
  return (
    <div className="App">
      <div className="image" align="left">
        <img className="x" src={x}></img>
        <img className="y" src={y}></img>
      </div>
      <DataTable />
      <Footer />
    </div>
  );
}

export default App;

