# datetime-parser
### supported operators:

increase date: + <br>
decrease date: - <br>
Rounds down to this time unit: @ <br>
### supported unit for input

year : y <br>
month : mon <br>
day : d <br>
hour : h <br>
minutes: m <br>
second: s <br>
### input example <br>

`String parsedDate = parse("now()+1y+10d-5m+5s");` <br>

output: `2023-04-07T10:33:18.791Z`
