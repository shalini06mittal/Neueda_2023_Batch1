let url = "http://localhost:8080/employees";

export async function getAllEmployees() {
  let response = await fetch(`${url}`);
  let employees = await response.json();
  console.log(employees);
  return employees;
}

export async function getEmployeeById(id) {
  let response = await fetch(`${url}/${id}`);
  let employee = await response.json();
  console.log(employee);
  return employee;
}

export async function addEmployee(employee) {
  let response = await fetch(`${url}`, {
    method: "POST",
    body: JSON.stringify(employee),
    headers: {
      "Content-Type": "application/json",
    },
  });
  let newemployee = await response.json();
  console.log(newemployee);
  return newemployee;
}

export async function deleteEmployee(id) {
  let response = await fetch(`${url}/${id}`, {
    method: "DELETE",
  });
  let data = await response.json();
  console.log(data);
  return data;
}
