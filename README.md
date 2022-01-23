# ToDo List BackEnd Project
<br />

## Description
<div style="width:70px; height:5px; border-radius:50px; background:#190082; margin-bottom: 20px"></div>

><br />
>Hi I'm Joseph a junior fullstack developer. This is an small project created by me.
>This ToDo List project will allow the user to create task, when this task gets marked as completed by the user, these tasks will be deleted from the user task object.
>
><br />

<br />

## Prerequisites
<div style="width:70px; height:5px; border-radius:50px; background:#190082; margin-bottom: 20px"></div>

><br />
><ol>
>  <li>Greater or equal to <a href="https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html" target=_blank>Java 11<a/>
>  <li><a href="https://maven.apache.org/download.cgi" target="_blank">Maven</a>
>  <li><a href="https://www.docker.com/get-started" target="_blank">Docker</a>
>  <li><a href="https://www.mongodb.com/try/download/community" target="_blank">MongoDB</a>
></ol>
><br />
<br />
<br />

## Endpoints
<div style="width:70px; height:5px; border-radius:50px; background:#190082; margin-bottom: 20px"></div>

><br />
><table>
>    <thead>
>        <tr>
>            <th>Entity
>            <th>Create
>            <th>Read
>            <th>Update
>            <th>Delete
>        </tr>
>    </thead>
>    <tbody>
>        <tr>
>            <td>User
>            <td><strong style="color:#FFC600">POST</strong>: /v1/user
>            <td><strong style="color:#34BE82">GET</strong>: /v1/user
>            <td><strong style="color:#2F86A6">PUT</strong>: /v1/user/:id
>            <td><strong style="color:#C85C5C">DELETE</strong>: /v1/user/:id
>        </tr>
>        <tr>
>            <td>Task
>            <td><strong style="color:#FFC600">POST</strong>: /v1/task/:userID
>            <td><strong style="color:#34BE82">GET</strong>: /v1/task
>            <td><strong style="color:#2F86A6">PUT</strong>: /v1/task/:id
>            <td><strong style="color:#C85C5C">DELETE</strong>: /v1/task/:id
>        </tr>
>    </tbody>
></table>
><br />
<br />
<div style="display:flex; width:250px">
    <div>
        <img src="https://i.ibb.co/CMTZdc2/isotipo-color.png" alt="isotipo-color" border="0" width="50px">
    </div>
    <p style="margin:auto;">Developed by <strong>Joseph Infante</strong></p>
</div>