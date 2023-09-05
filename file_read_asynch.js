
/*
Example of ASYNCHRONOUS file read.
Function readFile does not block (wait) for the file to be read.

Instead its argument function(err,data) will be called once the file has been read.
function(err,data) is the "call back" function that will be called when readFile's task is done.

Notice "DONE" gets written to the console before the file contents. Make
sure you understand why that is.
*/


const fs = require('fs')

fs.readFile('songs/sister_golden_hair.txt', function(err, data) {
  if(err) throw err
  let array = data.toString().split("\n")

  for(let line of array) { 
    let chordline = "";
    let lyricsline = " ";

  

    let wordsinline = line.split(" ");
    for(var i = 0; i < wordsinline.length; i++){
      if(wordsinline[i].startsWith("[") == true){
        lyricsline += "";
        let startIndex = wordsinline[i].indexOf("[");
        let endIndex = wordsinline[i].indexOf("]");
        let chord = wordsinline[i].slice(startIndex+1, endIndex);
        chordline += chord;
      }else{ 
        let spaces = "";
        lyricsline += wordsinline[i] + " ";
        for(var k=0; k<wordsinline[i].length; k++){
          spaces += " ";
        }
        chordline += spaces;
  
      }
    }
    const colour = require('colour');

    console.log(chordline.blue);
    console.log(lyricsline.green);
  }

console.log("DONE");
})
