window.addEventListener("load", function () {
    function getxhr(){
        let xhr;
        try {  xhr = new ActiveXObject('Msxml2.XMLHTTP');   }
        catch (e) 
        {
            try {   xhr = new ActiveXObject('Microsoft.XMLHTTP'); }
            catch (e2) 
            {
               try {  xhr = new XMLHttpRequest();  }
               catch (e3) {  xhr = false;   }
             }
        }
        return xhr;
      }
    function submitget()
    { 
        // let name=document.getElementById("name");
        //let password=document.getElementById("password");
        //création de l'objet XMLHttpRequest
        alert("haha");
        var xhr=getxhr();
        var formData = new FormData(form);
        //Définition des changements d'états    
        xhr.onreadystatechange  = function() 
        { 
           if(xhr.readyState  == 4){
            if(xhr.status  == 200) {
                var retour =xhr.responseText;
                alert(retour);
        
            } else {
                document.dyn="Error code " + xhr.status;
            }
            }
        }; 
      //XMLHttpRequest.open(method, url, async)
       xhr.open("GET","http://localhost:8080/ClassMarques/marques",true); 
       //xhr.open("POST", "http://localhost:8080/utilisateurClass/utilisateur/{nom}/{passe}",true); 
       
       //XMLHttpRequest.send(body)
       xhr.send(null); 
    }
    // Accédez à l'élément form …
    var form = document.getElementById("login");
    
    // … et prenez en charge l'événement submit.
    form.addEventListener("submit", function (event) {
      event.preventDefault(); // évite de faire le submit par défaut
      submitget();
    });
    
    });