<html>
 <head></head>
 <body>
  <div class="container-fluid pt-4 px-4">
   <div class="row g-4">
    <div class="col-sm-12 col-xl-6">
     <div class="bg-secondary rounded h-100 p-4">
      <h6 class="mb-4">Creation d'employe</h6>
      <form>
       <div class="mb-3">
        <label for="nominput" class="form-label">Nom</label> <input type="text" class="form-control" id="nominput" aria-describedby="nomhelp" name="nom">
        <div id="nomhelp" class="form-text">
         Votre nom restera confidentiel
        </div>
       </div>
       <div class="form-floating mb-3">
        <select class="form-select" id="embaucheSelect" aria-label="" name="embauche"> <option selected>All</option> </select> <label for="embaucheSelect">Embauche</label>
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