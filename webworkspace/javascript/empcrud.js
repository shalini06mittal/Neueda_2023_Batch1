let url = "http://localhost:8080/employees"
let output = document.getElementById('output')
function getAllEmployees()
{
    output.innerHTML=''
    fetch(url)
    .then(res=>res.json())
    .then(employees =>{
        console.log(employees)
        let tb = document.createElement('table')
        tb.setAttribute('class','table')
        let tablerow = document.createElement('tr')
        let tableheading1 = document.createElement('th')
        tableheading1.textContent= ('Name')
        let tableheading2 = document.createElement('th')
        tableheading2.textContent = ('Region')
        let tableheading3 = document.createElement('th')
        tableheading3.textContent = ('Salary')
        let tableheading4 = document.createElement('th')
        tableheading4.textContent = ('Action')
        tablerow.appendChild(tableheading1);
        tablerow.appendChild(tableheading2);
        tablerow.appendChild(tableheading3);
        tablerow.appendChild(tableheading4);
        tb.appendChild(tablerow)
        for(let employee of employees){
            tablerow = document.createElement('tr')
            tableheading1 = document.createElement('td')
            tableheading1.textContent= employee.name
            tableheading2 = document.createElement('td')
            tableheading2.textContent = employee.region
            tableheading3 = document.createElement('td')
            tableheading3.textContent = employee.dosh
            tableheading4 = document.createElement('td')
            let btndel = document.createElement('button')
            btndel.setAttribute('class','btn')
            btndel.setAttribute('id',`del${employee.employeeId}`)
            btndel.textContent = 'DEL'
            
            btndel.addEventListener('click',async(e)=>{
               // alert('hey clicked '+e.target.getAttribute('id'))
                console.log(e)
                console.log(`${url}/${employee.employeeId}`)
                let response = await fetch(`${url}/${employee.employeeId}`,{
                    method:'DELETE'
                })
                let data = await response.json()
                console.log(data);
            })
            
            let btnedit = document.createElement('button')

            btnedit.setAttribute('class','btn')
            btnedit.setAttribute('id',`edit${employee.employeeId}`)
            btnedit.textContent = 'EDIT'
            tableheading4.appendChild(btndel);
            tableheading4.appendChild(btnedit);
            tablerow.appendChild(tableheading1);
            tablerow.appendChild(tableheading2);
            tablerow.appendChild(tableheading3);
            tablerow.appendChild(tableheading4)
            tb.appendChild(tablerow)
        }
       
        output.appendChild(tb)
    })
}
function addEmployee()
{
    output.innerHTML=''
    let str=`
    <form id='emp'>
        <div class="mb-3">
            <label htmlFor="formGroupExampleInput2" class="form-label">Name
                </label> <input type="text" class="form-control"
                name="name" 
                id="name" placeholder="Name"/>
        </div>
        <div class="mb-3">
            <label htmlFor="formGroupExampleInput2" class="form-label">Region
                </label> <input type="text" class="form-control"
                name="region" 
                id="region" placeholder="Region"/>
        </div>
        <div class="mb-3">
            <label htmlFor="formGroupExampleInput2" class="form-label">salary
                </label> <input type="text" class="form-control"
                name="dosh" 
                id="dosh" placeholder="Salary"/>
        </div>
        <button type="submit" class="btn btn-primary">SAVE</button>
    </form>
    `;
    output.innerHTML=str;
    document.getElementById('emp').addEventListener('submit',saveEmployee);

    async function saveEmployee(event)
    {
        event.preventDefault();
        alert('click')
        let name = document.getElementById('name').value
        let dosh = document.getElementById('dosh').value
        let region = document.getElementById('region').value
        let employee = {name, dosh, region}
        console.log(employee)
        let response = await fetch(`${url}`,{
            method:'POST',
            body: JSON.stringify(employee),
            headers:{
                'Content-Type' : 'application/json'
            }
        });
        let data = await response.json()
        console.log(data);
        name.value=''
        region.value=''
        dosh.value=''
        return data;
       
    }
}