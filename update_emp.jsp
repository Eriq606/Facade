<html>
 <head></head>
 <body>
  <div class="container-fluid pt-4 px-4">
   <div class="row g-4">
    <div class="col-sm-12 col-xl-6">
     <div class="bg-secondary rounded h-100 p-4">
      <h6 class="mb-4">Modifier un employe</h6>
      <form>
       <div class="mb-3">
        <label for="nominput" class="form-label">Nom</label> <input type="text" class="form-control" id="nominput" aria-describedby="nomhelp" name="nom">
        <div id="nomhelp" class="form-text">
         Votre nom restera confidentiel
        </div>
       </div>
       <div class="mb-3">
        <label for="embaucheinput" class="form-label">Embauche</label> <input type="datetime-local" class="form-control" id="embaucheinput" aria-describedby="embauchehelp" name="embauche">
        <div id="embauchehelp" class="form-text">
        </div>
       </div>
       <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="marriedcheck" name="married"> <label class="form-check-label" for="marriedcheck">Est marie</label>
       </div>
      </form>
     </div>
    </div>
   </div>
  </div>
 </body>
</html>