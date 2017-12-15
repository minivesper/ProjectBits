var Body_elem = document.getElementById('body');
var Avail_dice = []
var start_tri = null;
function pageLoaded() {
  initMenu();
  initBoard();

}

//sets up baords.
function initBoard() {
  for(i = 0; i < 24; i++) {
    if(i%6 == 0 && i > 0)
    {
      var line_elem = document.createElement('label');
      line_elem.innerHTML= '-------------';
      Body_elem.appendChild(line_elem);
    }
    var tri_elem = document.createElement('ul');
    tri_elem.onclick= triClicked;
    tri_elem.id = (i+1).toString();
    Body_elem.appendChild(tri_elem);
    var list_elem = document.createElement('li');
    list_elem.innerHTML = (i+1)+': ';
    tri_elem.appendChild(list_elem);
  }
  var tri1 = document.getElementById('1');
  var tri24 = document.getElementById('24');
  for(i = 0; i < 2; i ++){
    blp = addPiece(true);
    whp = addPiece(false);
    tri1.appendChild(whp);
    tri24.appendChild(blp);
  }
  var tri6 = document.getElementById('6');
  var tri19 = document.getElementById('19');
  for(i = 0; i < 5; i ++){
    blp = addPiece(true);
    whp = addPiece(false);
    tri6.appendChild(blp);
    tri19.appendChild(whp);
  }
  var tri8 = document.getElementById('8');
  var tri17 = document.getElementById('17');
  for(i = 0; i < 3; i ++){
    blp = addPiece(true);
    whp = addPiece(false);
    tri8.appendChild(blp);
    tri17.appendChild(whp);
  }
  var tri12 = document.getElementById('12');
  var tri13 = document.getElementById('13');
  for(i = 0; i < 5; i ++){
    blp = addPiece(true);
    whp = addPiece(false);
    tri12.appendChild(whp);
    tri13.appendChild(blp);
  }
}

//this will do the initial buttons that appear and decide pvp pvc cvc and difficulty
function initMenu() {

}
//adds pieces to boards
function addPiece(Black_piece) {
  var list_elem = document.createElement('li');
  if(Black_piece) {
    list_elem.innerHTML = 'X';
  }
  else {
    list_elem.innerHTML = 'O';
  }
  return list_elem;
}

//moves a piece from tri from to tri to
function movePiece(from, to) {
  //checkCollision(toTri);
  var fromTri= document.getElementById(from);
  var toTri= document.getElementById(to);
  var fromPiece = fromTri.children[1];
  toTri.appendChild(fromPiece);
}

//returns an array of distances pieces can move
function rollDice() {
  if(start_tri != null) {
    alert('finish your turn');
    return;
  }
  var d1 = Math.floor((Math.random() * 6) + 1);
  var d2 = Math.floor((Math.random() * 6) + 1);
  console.log(d1 + " " + d2);
  if(d1 == d2) {
    var darr = [d1,d1,d1,d1]
    updateLabel(darr);
    Avail_dice = darr
  }
  else {
    var darr = [d1,d2];
    updateLabel(darr);
    Avail_dice = darr;
  }
}

function updateLabel(dice) {
  var d_string = ''
  for(i = 0; i < dice.length; i++) {
    d_string += (" "+dice[i])
  }
    document.getElementById('dice_label').innerHTML= d_string;
}

function triClicked(evt) {
  if(Avail_dice.length == 0)
  {
    alert("You gotta roll the dice first!");
    return;
  }
  if(start_tri == null) {
    start_tri = evt.target;
  }
  else {
    checkMove(Avail_dice,start_tri.id,evt.target.id);
    start_tri = null;
  }
}

function checkMove(dieArray, from, to) {
  console.log(dieArray);
  console.log(dieArray + " " + from + " " + to);
  for(i = 0; i < dieArray.length; i++) {
    if(dieArray[i] == (Math.abs(from-to)) && (((from-to < 0) && document.getElementById(from).children[1].innerHTML == 'O') || ((from-to > 0) && document.getElementById(from).children[1].innerHTML == 'X'))) {
      movePiece(from, to);
      dieArray.splice(i,1);
      updateLabel(dieArray);
      return;
    }
  }
  alert("not a possible move")
}
