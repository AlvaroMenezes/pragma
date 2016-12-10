## Plataform and Language
Android Java
## Tools
* AndroidStudio
* SourceTree
* Github

## External Libraries
* Retrofit
* Picasso

## Architecture
* MVP
* Observer

## REST API
* Zomato

## Comments

First story that I considerate was number 5, I target minimun SDK 10 to cover 100% devices but when I implement notification I need up minimun to 16.<br>
For android equals or above 6.0  the permission change, so I need create a version validator to manage  permission.<br>
<br>
The story 1 work ok I list the restaurans based on current gps position, mach with Zomato API.<br>
For the votes of each restaurant I mock data because I understand that it is server side responsibility and I not implement the server side of this application.<br>
One observer work with a thread running in background  basically consume same rest cited above, the ideia is update the votes that are saved in the fake server.<br>
The field total votes are a random number.<br>
The list are sorted decrescent order by number of votes.<br>

When occurs the vote (click at hearth icon) the reference of the vote are save into a preferences(id and day) and is calling one fake webservice to vote send the IMEI of device, because there is no login so the server simulated would control for have just one vote per device, with this I finish story 2<br>

the story 3 I imagined consume one web service with places voted, and eliminate for the current list in the moment of call, so I put some todo in the code, it is easy to do but as I wrote we dont have backend.<br>

Finally story 4 the app has a menu on top right I set the same web service Zomato but returning just one restaurant and hardcoded lat long near lisbon, just to show a diferente place to simulate the last one chosen<br>

PLUS* I add one more fragment to see the restaurant details, there ont the botton  has a button to book a table, so the app work then if you like go ahead.<br>

## Gap
I recognize that tests are my weak, generally my projects not use tests, so im sorry for not made a great homework in relation this, but it isn't another world moster, so with a few  more practice I could improve in this area.

<br>

I thank you very much for this opportunity!!!

 


