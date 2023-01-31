$(document).ready(function() {
   // on ready
});


async function login() {
  console.log("\t\t---LLamada a login.js ...")
  let datos = {};
  datos.nombre = document.getElementById('formUser').value;
  datos.password = document.getElementById('formPassword').value;

  console.log("\t\t---LLamada a login.js ..." + datos.Nombre + " " + datos.Password)

  //Peticion con los datos del usuario al endpoint de login
  const request = await fetch('login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  const respuesta = await request.text();
  if (respuesta != 'FAIL') {
    //Redirigir a la página siguiente
    window.location.href = 'myAcount.html'
  } else {
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }

}