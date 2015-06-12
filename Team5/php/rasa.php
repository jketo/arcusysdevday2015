<?php
$totalLines = 0;
$totalRasa = 0;
for($i = 1; isset($argv[$i]); $i++) {
    $file = $argv[$i];
    $lines =  count(file($file));
    $rasa = rasa(file_get_contents($file), 1);
    $totalLines += $lines;
    $totalRasa += $rasa;
    echo "$file: lines " . $lines . ", RaSa " . $rasa ."\n";

}
echo "total: lines $totalLines, RaSa $totalRasa \n";

function rasa($code, $depth)
{
    $stms = 0;
    $rasa = 0;

    $chars = str_split($code);
    for($i = 0; $i < strlen($code); $i++) {
        $c = $chars[$i];
        if($c === ";") {
            $stms++;
        } elseif($c === "{") {

            $block = readBlock(substr($code, $i));
            $i += strlen($block);
            $rasa += rasa($block, $depth + 1);

        } 
    }
    return $rasa + $stms * $depth;
}

function readBlock($input)
{
    $stack = [];
    $chars = str_split($input);
    $char = current($chars);
    $output = "";
    do {
        if($char === '{') {
            array_push($stack, $char);
        } elseif($char === '}') {
            array_pop($stack);
        }
        $output .= $char;
        $char = next($chars);
    } while(!empty($stack) && $char !== false);
    return substr($output, 1, strlen($output) - 2);

}