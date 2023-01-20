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
        //création de l'objet XMLHttpRequest
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
       xhr.open("POST", "controller/controllerInsertTirage.php",true); 
       
       //XMLHttpRequest.send(body)
       xhr.send(formData); 
    }

    function addDataInList(data){
        let list=document.getElementById('liste');
        let taille=data.length;
        for(let i=0;i<taille;i++){
            let node=document.createElement("li");
            let link=document.createElement("a");
            link.
            node.value=data[i]['id'];

            node
            list.appendChild(node)

        }
    }
    function createElementList(data){
        
    }

    function formNewSelect(place,part,object){
        let taille=object.length;
        let name="id"+part;
        for(let a=0;a<taille;a++){
          let node=document.createElement("option");
          node.value=object[a][name];
          let text=document.createTextNode(object[a]["nom"]);
          node.appendChild(text);
          place.appendChild(node) 
        }
        place.disabled=false;
    }
    });