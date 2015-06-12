fs = require('fs');
var totalLines = 0;
var totalRasa = 0;
process.argv.forEach(function (val, index, array) {
  if(index > 1) {
  	var lines;
  	fs.open(val, 'r', function(err, fd) {
  		lines = fd;
  		totalLines += fd;
  	});
  	fs.readFile(val, 'utf8', function (err,data) {
	  if (err) {
	    return console.log(err);
	  }
	  var rasaScore = rasa(data, 1);
	  totalRasa += rasaScore;
	  console.log(val + ": lines " + lines + ", RaSa " + rasaScore);
	});
  } else if (index +1=== array.length) {
  	console.log("total: lines " + totalLines + ", RaSa " + totalRasa);
  }
});
function rasa(code, depth) {
	var stms = 0;
	var rasaScore = 0;


	for (var i = 0; i < code.length; i++) {
		var c = code[i];
		if(c === ";") {
			stms++;
		} else if(c === "{") {
			var block = readBlock(code.substr(i));
			i = i + block.length;
			rasaScore += rasa(block, depth+1);
		}
	}
	return rasaScore + stms * depth;
}

function readBlock(input) {
	var stack = Array();
	var output = "";
	for(var i = 0; i < input.length; i++) {
		var c = input[i];
		if(c === "{") {
			stack.push(c);
		} else if(c === "}") {
			stack.pop();
		}
		output = output.concat(c);
		if(stack.length === 0) {
			break;
		}
	}
	return output.substr(1, output.length -2);
}