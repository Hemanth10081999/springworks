
function handleClick(){
    console.log('hello');
    const name=document.getElementById('inputName').value;
    const email=document.getElementById('inputEmail').value;
    const phone=document.getElementById('inputPhone').value;
    const password=document.getElementById('inputPassword').value;
    const repassword=document.getElementById('rePassword').value;
    const url='http://localhost:8080/api/logins';

    
    if(name.length<3 || name.length>20){
        console.log("user name should be with in 4 to 20 characters")
        alert("user name should be with in 4 to 20 characters");
    }
    else{

        if(password!=repassword){
            console.log('pasword mismatch');
            alert("password mismatch");
        
        }

        else{
            var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
            if(password.match(decimal)){
                const data={
                    'userName': name,
                    'mailid': email,
                    'phone': phone,
                    'password': password
                };
    
                console.log(''+JSON.stringify(data));
                fetch(url,{
                    method: 'POST',
                    headers: {
                        'Content-Type':'application/json',
                    },
                    body: JSON.stringify(data),
                })
                .then(response => response.json())
                    .then(data => console.log(JSON.stringify(data)))
                    .catch(error => console.error(error))
            }
            else{
                console.log('Password must contain 8 to 15 characters which contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character');
                alert("password must contain 8 to 15 characters which contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character");
                
            }
        }
    }
}


function postData(url='',data={}){
    console.log('posting starts');
    return fetch(url,{
        method:'POST',
        mode:'cors',
        cache: 'no-cache',
        credentials:'same-origin',
        headers:{
            'Content-Type':'application/json',
        },
        redirect:'follow',
        referrer: 'no-refrrer',
        body: JSON.stringify(data),
    })
    .then(response => response.json());
}

function loginClick(){
    console.log('entered into click');
    const email=document.getElementById('logEmail').value;
    const password=document.getElementById('logPassword').value;

    const Data={
        url: 'http://localhost:8080/api/logins/login',
        data: {
            'mailid':email,
            'password':password
        }
    };
    postData(Data.url,Data.data)
    .then(data=>{
        if((JSON.stringify(data))=="true")
        {
            window.location="https://www.google.com/";
        }
        else{
            alert("Bad login credentials")
        }
        
    })
    .catch(error=>alert("Error occured in server"));
}