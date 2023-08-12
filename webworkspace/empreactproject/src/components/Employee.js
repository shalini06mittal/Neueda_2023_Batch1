import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { deleteEmployee, getEmployeeById } from '../services/empservice'

export default function Employee() {
    let {id} = useParams()
    let navigate = useNavigate()
    const [employee, setEmployee] = useState({})

    useEffect(()=>{
        getEmployeeById(Number(id)).then(res=>setEmployee(res))
    })

    const delEmployee = ()=>{
        deleteEmployee(Number(id))
        .then(res=>navigate('/'))
    }
  return (
    <div className='container mt-5'>
        <h1>Name : {employee?.name}</h1>
        <p>Region: {employee?.region}</p>
        <p>Salary: {employee?.dosh}</p>
        <p><button onClick={delEmployee}>DEl</button></p>
    </div>
  )
}
