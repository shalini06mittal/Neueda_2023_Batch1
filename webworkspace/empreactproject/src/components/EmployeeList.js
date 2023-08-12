import React, { useEffect, useState } from 'react'
import {getAllEmployees} from '../services/empservice'
import { NavLink, Outlet } from 'react-router-dom';
export default function EmployeeList() {
    const [employees, setemployees] = useState([])

    useEffect(()=>{
        getAllEmployees().then(employees=>setemployees(employees));
    },[])
  return (
    <div>
        {/* <p>{JSON.stringify(employees)}</p> */}
        <div className='row mt-5'>
            <div className='col-md-3' style={{borderRight:'2px solid black'}}>
            <ul className="list-group list-group-flush">
                {
                    
                    employees.length &&(
                    employees.map(employee => (
                        <li key={employee.employeeId} className="list-group-item">
                        <NavLink to={`/${employee.employeeId}`}>
                            {employee.name}
                        </NavLink>
                        </li>
                    ))
                    )
                }
            </ul>
            </div>
            <div className='col-md-9'>
                
                <Outlet/>
            </div>
        </div>
    </div>
  )
}
