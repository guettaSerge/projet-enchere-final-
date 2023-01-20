window.addEventListener("load", function () {
    submitget();

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
    function submitget()
    { 
        //création de l'objet XMLHttpRequest
        var xhr=getxhr();
        //Définition des changements d'états    
        xhr.onreadystatechange  = function() 
        { 
           if(xhr.readyState  == 4){
            if(xhr.status  == 200) {
                let retour =xhr.responseText;
                let data=JSON.parse(retour);
                alert(retour);
                chargeTable(data["data"]);
                
            } else {
                document.dyn="Error code " + xhr.status;
            }
            }
        }; 
      //XMLHttpRequest.open(method, url, async)
       xhr.open("GET", "http://localhost:8080/vehicule/vehicules",true); 
       
       //XMLHttpRequest.send(body)
       xhr.send(); 
    }
    function submitgetForm(form)
    { 
        // Liez l'objet FormData et l'élément form
        var formData = new FormData(form);
        //création de l'objet XMLHttpRequest
        var xhr=getxhr();
        //Définition des changements d'états    
        xhr.onreadystatechange  = function() 
        { 
           if(xhr.readyState  == 4){
            if(xhr.status  == 200) {
                let retour =xhr.responseText;
                let data=JSON.parse(retour);
                alert(retour);
                chargeTable(data["data"]);
                
            } else {
                document.dyn="Error code " + xhr.status;
            }
            }
        }; 
      //XMLHttpRequest.open(method, url, async)
       xhr.open("GET", "http://localhost:8080/vehicule/vehicules",true); 
       
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

    ///remove element from table
    function removeAllchild(place){
        let children=place.children;
        while(children.length>0){
          place.removeChild(children[0]);
        }
      }
      function removeVariable(id){
        let place=document.getElementById(id);
        removeAllchild(place)
        place.disabled=true;
      }
    //fonction permettant de charger le tableau
    function chargeTable(data){
        let table=document.getElementById("tableList");
        removeAllchild(table);
        let taille=data.length;
        for(let i=0;i<taille;i++){
            let tr=createTr(data[i]);
            table.appendChild(tr);
        }
    }
    function createTr(data){
        let tr=document.createElement("tr");
        let td1= createTd(data['idVehicule']);
        let td2= createTd(data['matricule']);
        let td3= createTd(data['idType']);
        let form=buildButton(data['idVehicule']);
        let td=document.createElement("td");
        td.appendChild(form);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td);
        return tr;
      
    }
    function buildButton(id){
        let form=document.createElement("form");
        let input=document.createElement("input");
        input.type="hidden";
        input.name="idVehicule"
        input.value=id
        let input2=document.createElement("input");
        input2.type="submit";
        input2.value="detail";
        input2.className="btn btn-primary";
        form.appendChild(input);
        form.appendChild(input2);
        return form;

    }
    function createTd(data){
        let td=document.createElement("td");
        let text=document.createTextNode(data);
        td.appendChild(text);
        return td;
    }
    function removeElement($table){

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