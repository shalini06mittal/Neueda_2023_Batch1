import logo from './logo.svg';
import './App.css';
import {Route, Routes} from 'react-router-dom'
import NavBar from './components/NavBar';
import About from './components/About';
import Contact from './components/Contact';
import EmployeeList from './components/EmployeeList';
import Employee from './components/Employee';
import AddNewemployee from './components/AddNewemployee';
function App() {
  return (
    <div>
      <NavBar/>
      <div className='container'>
      <Routes>
        <Route path='/' element={<EmployeeList/>}>
          <Route path=':id' element={<Employee/>}/>
          </Route>
        <Route path='/about' element={<About/>}/>
        <Route path='/contact' element={<Contact/>}/>
        <Route path='/add' element={<AddNewemployee/>}/>
      </Routes>
      </div>
    </div>
  );
}

export default App;
