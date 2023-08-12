/**
 * callback hell
 * closures - javascript
 */
// simple function
// function getUsers(){
//     return [
//         {username:"u1", email:"u1@gmail.com"},
//         {username:"u2", email:"u2@gmail.com"},
//         {username:"u3", email:"u3@gmail.com"},
//     ];
// }

//console.log(getUsers())

// REST API http://domainname/users => [{},{}]
// function with a delay running an asynchronous call
// function getUsers(){
//     let users = []
//     setTimeout(() => {
//         users = [
//             {username:"u1", email:"u1@gmail.com"},
//             {username:"u2", email:"u2@gmail.com"},
//             {username:"u3", email:"u3@gmail.com"},
//         ];
//     }, 2000);
//     return users;
// }
// console.log(getUsers())
// Using callbacks
let statusmsg = true;
function getUsers(callback){ // callback = displayAllUsers(users[])
    console.log('fetchind data')
    setTimeout(() => {
        if(statusmsg){
            let users = [
                {username:"u1", email:"u1@gmail.com"},
                {username:"u2", email:"u2@gmail.com"},
                {username:"u3", email:"u3@gmail.com"},
            ]
            callback(users, null);
        }
        else 
            callback(null,'No data')
    }, 2000);
}

function displayAllUsers(result, error){
    console.log('d')
    if(error === null)
        console.log(result)
    else 
        console.log(error)

}
//getUsers(displayAllUsers)

// Using Promises

function getUsers(){
    return new Promise((resolve, reject)=>{
        setTimeout(() => {
            if(statusmsg){
                let users = [
                    {username:"u1", email:"u1@gmail.com"},
                    {username:"u2", email:"u2@gmail.com"},
                    {username:"u3", email:"u3@gmail.com"},
                ]
                resolve(users);
            }
            else reject('No data')
        }, 2000)   
    });
}
//getUsers().then(res => console.log(res), rej => console.log(rej))



/**
 * Promises => Promise
 * RESt API => success , failure
 * http://domain/user
 */

// let promise = new Promise((resolve, reject)=>{
//     //console.log('promise object created');
//     // REST API
//     if(statusmsg){
//         resolve('IT is a success')
//     }
//     else
//     reject('something went wrong')
// })

// promise.then((data)=> console.log(data), (reject)=> console.log(reject))
// .catch(err=> console.log(err))


