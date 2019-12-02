/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validadFormulario(forma) {
    // Usuario
    var usuario=forma.usuario;
    if(usuario.value.length==0){
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
    }
     // A. Paterno
    var appa=forma.appa;
    if(appa.value.length==0){
        alert("Debe proporcionar un apellido paterno");
        appa.focus();
        appa.select();
    }
      // A. Materno
    var apma=forma.apma;
    if(apma.value.length==0){
        alert("Debe proporcionar un apellido paterno");
        apma.focus();
        apma.select();
    }
    
    ///password
    var password = forma.password;
    if (password == "" || password.value.length < 8) {
        alert("Debe proporcionar una contraseña de al menos 8 caracteres");
        password.focus();
        password.select();
    }
    
   //genero
    var genero=forma.genero;
    var selecciongenero=false;
    for(var i=0;i<genero.length;i++){
        if(genero[i].checked){
            selecciongenero=true;
            break;
        }
    }
    if(!selecciongenero){
        return false;
    }
    //municipio de nayarit
    
    var ocupacion = forma.ocupacion;
    if (ocupacion.value == "") {
        alert("Debera seleccionar una ocupacion");
        ocupacion.focus();
        ocupacion.select();
        return true;
    }  
}

function limpiarFormulario(forma2) {
   
    var usuario = forma2.usuario;
    var appa = forma2.appa;
    var apma = forma2.apma;
    var password = forma2.password;
    var genero = forma2.genero;
    var ocupacion = forma2.ocupacion;
    usuario.setText(" ");
    appa.setText(" ");
    apma.setText(" ");
    password.setText(" ");
    genero.setText(" ");
    ocupacion.setText(" ");
    }
   
    


