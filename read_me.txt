HTML part is in src/app/app.component.html.
When search, the text in text box is passed to app.cpmponent.ts file. (line 35)
Here you have to change the 'base_url' in line 38 as according to system.
I used 'GET; call there.
Then in line 45 you have to bind the result json object into searchList. (here i have use hard coded json body named 'dta' which mentioned in line 18)
In html (app.component.html.) we can change the view according to the result object parameters (here i only add name and download button).
When clicking download button, onDownload() function triggered. (app.component.ts)
Then also you have to set 'base_url' in line 78 according to backend download url.
'searchTerm' in line 78 is the link.
In line 66 file in the url is downloaded as a mp3 expention.
need 'npm install' to install the project.

Really sorry guys that i will not be able to involve in this project as you guys. This happens because my wedding is falls on 8th of July. So im really busy with wedding stuff. I know my involment is very poor. Again really sorry for that. If you add individual involment into project report, Just add only few parts done by me under my name. Again sorry for my role is so poor.



 

