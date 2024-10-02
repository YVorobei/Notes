<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="generator" content="Asciidoctor 2.0.22">

</head>
<body class="article">
<div id="header">
<h1>Notes Service SDD</h1>
<div id="toc" class="toc">
<img src="https://raw.githubusercontent.com/YVorobei/Notes/main/note-service-doc/diagrams/notes-component-diagram.svg" alt="notes component diagram" width="600">
<ul class="sectlevel1">
<li><a href="#_introduction">Introduction</a>
<ul class="sectlevel2">
<li><a href="#_sequence_diagrams">Sequence Diagrams</a>
<ul class="sectlevel3">
<li><a href="#_create_note_via_api">Create note via API:</a></li>
<li><a href="#_search_note_by_id_via_api">Search note by id via API:</a></li>
<li><a href="#_get_all_notes_via_api">Get all notes via API:</a></li>
<li><a href="#_update_note_via_api">Update note via API:</a></li>
<li><a href="#_delete_note_via_api">Delete note via API:</a></li>
</ul>
</li>
</ul>
</li>
<li><a href="#_api">API</a>
<ul class="sectlevel3">
<li><a href="#_create_note">Create note</a></li>
<li><a href="#_search_note_by_id">Search note by id</a></li>
<li><a href="#_get_all_notes">Get all notes</a></li>
<li><a href="#_update_note">Update note</a></li>
<li><a href="#_delete_note_by_id">Delete note by id</a></li>
</ul>
</li>
</ul>
</div>
</div>
<div id="content">
<div class="sect1">
<h2 id="_introduction">Introduction</h2>
<div class="sectionbody">
<div class="paragraph">
<p>This service is responsible for creating notes.</p>
</div>
<div class="sect2">
<h3 id="_sequence_diagrams">Sequence Diagrams</h3>
<div class="sect3">
<h4 id="_create_note_via_api">Create note via API:</h4>
<hr>
<div class="imageblock">
<div class="content">
<img src="https://raw.githubusercontent.com/YVorobei/Notes/main/note-service-doc/readme/create-notes.svg" alt="create notes" width="341" height="280">
</div>
</div>
</div>
<div class="sect3">
<h4 id="_search_note_by_id_via_api">Search note by id via API:</h4>
<hr>
<div class="imageblock">
<div class="content">
<img src="https://raw.githubusercontent.com/YVorobei/Notes/1a03ede9aea9582dbc0aa230190665337925091b/note-service-doc/readme/search-notes.svg" alt="search notes">
</div>
</div>
</div>
<div class="sect3">
<h4 id="_get_all_notes_via_api">Get all notes via API:</h4>
<hr>
<div class="imageblock">
<div class="content">
<img src="https://raw.githubusercontent.com/YVorobei/Notes/1a03ede9aea9582dbc0aa230190665337925091b/note-service-doc/readme/get-all-notes.svg">
</div>
</div>
</div>
<div class="sect3">
<h4 id="_update_note_via_api">Update note via API:</h4>
<hr>
<div class="imageblock">
<div class="content">
<img src="https://raw.githubusercontent.com/YVorobei/Notes/main/note-service-doc/readme/update-notes.svg" alt="update notes" width="354" height="343">
</div>
</div>
</div>
<div class="sect3">
<h4 id="_delete_note_via_api">Delete note via API:</h4>
<hr>
<div class="imageblock">
<div class="content">
<img src="https://raw.githubusercontent.com/YVorobei/Notes/main/note-service-doc/readme/delete-notes.svg" alt="delete notes" width="350" height="280">
</div>
</div>
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="_api">API</h2>
<hr>
<div class="sectionbody">
<div class="sect3">
<h4 id="_create_note">Create note</h4>
<div class="listingblock">
<div class="content">
<pre class="CodeRay highlight"><code data-lang="http">POST /notes/create</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="CodeRay highlight"><code data-lang="json">    {
      <span style="color:#606"><span style="color:#404">&quot;</span><span>title</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">title</span><span style="color:#710">&quot;</span></span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>message</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">msg</span><span style="color:#710">&quot;</span></span>
    }</code></pre>
</div>
</div>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 50%;">
<col style="width: 50%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Response Code</th>
<th class="tableblock halign-left valign-top">Description</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Successful response.</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect3">
<h4 id="_search_note_by_id">Search note by id</h4>
<div class="listingblock">
<div class="content">
<pre class="CodeRay highlight"><code data-lang="http">GET /notes/searsch/{id}</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="CodeRay highlight"><code data-lang="json">{
      <span style="color:#606"><span style="color:#404">&quot;</span><span>id</span><span style="color:#404">&quot;</span></span>: <span style="color:#00D">1</span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>title</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">title_1</span><span style="color:#710">&quot;</span></span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>message</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">msg</span><span style="color:#710">&quot;</span></span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>date_creation</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#710">&quot;</span></span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>date_update</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#710">&quot;</span></span>
}</code></pre>
</div>
</div>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 50%;">
<col style="width: 50%;">
</colgroup>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">Response Code</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Description</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Successful response, return note.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">404</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Unable to find note.</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect3">
<h4 id="_get_all_notes">Get all notes</h4>
<div class="listingblock">
<div class="content">
<pre class="CodeRay highlight"><code data-lang="http">GET /notes/getall</code></pre>
</div>
</div>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 50%;">
<col style="width: 50%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Response Code</th>
<th class="tableblock halign-left valign-top">Description</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Successful response, list of notes returned.</p></td>
</tr>
</tbody>
</table>
<div class="paragraph">
<p>Response body:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="CodeRay highlight"><code data-lang="json">{
  <span style="color:#606"><span style="color:#404">&quot;</span><span>notes</span><span style="color:#404">&quot;</span></span>: [
    {
      <span style="color:#606"><span style="color:#404">&quot;</span><span>id</span><span style="color:#404">&quot;</span></span>: <span style="color:#00D">1</span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>title</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">title_1</span><span style="color:#710">&quot;</span></span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>message</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">msg</span><span style="color:#710">&quot;</span></span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>date_creation</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#710">&quot;</span></span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>date_update</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#710">&quot;</span></span>
    },
    {
      <span style="color:#606"><span style="color:#404">&quot;</span><span>id</span><span style="color:#404">&quot;</span></span>: <span style="color:#00D">2</span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>title</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">title_2</span><span style="color:#710">&quot;</span></span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>message</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">msg2</span><span style="color:#710">&quot;</span></span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>date_creation</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#710">&quot;</span></span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>date_update</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#710">&quot;</span></span>
    }
  ]
}</code></pre>
</div>
</div>
</div>
<div class="sect3">
<h4 id="_update_note">Update note</h4>
<div class="listingblock">
<div class="content">
<pre class="CodeRay highlight"><code data-lang="http">PUT /notes/update/{id}</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="CodeRay highlight"><code data-lang="json">    {
      <span style="color:#606"><span style="color:#404">&quot;</span><span>title</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">title</span><span style="color:#710">&quot;</span></span>,
      <span style="color:#606"><span style="color:#404">&quot;</span><span>message</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">msg</span><span style="color:#710">&quot;</span></span>
    }</code></pre>
</div>
</div>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 50%;">
<col style="width: 50%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Response Code</th>
<th class="tableblock halign-left valign-top">Description</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Successful response.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">404</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Unable to find note.</p></td>
</tr>
</tbody>
</table>
<div class="paragraph">
<p>Response body:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="CodeRay highlight"><code data-lang="json">{
   <span style="color:#606"><span style="color:#404">&quot;</span><span>id</span><span style="color:#404">&quot;</span></span>: <span style="color:#00D">1</span>,
   <span style="color:#606"><span style="color:#404">&quot;</span><span>title</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">title_1</span><span style="color:#710">&quot;</span></span>,
   <span style="color:#606"><span style="color:#404">&quot;</span><span>message</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#D20">msg</span><span style="color:#710">&quot;</span></span>,
   <span style="color:#606"><span style="color:#404">&quot;</span><span>date_creation</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#710">&quot;</span></span>,
   <span style="color:#606"><span style="color:#404">&quot;</span><span>date_update</span><span style="color:#404">&quot;</span></span>: <span style="background-color:hsla(0,100%,50%,0.05)"><span style="color:#710">&quot;</span><span style="color:#710">&quot;</span></span>
}</code></pre>
</div>
</div>
</div>
<div class="sect3">
<h4 id="_delete_note_by_id">Delete note by id</h4>
<div class="listingblock">
<div class="content">
<pre class="CodeRay highlight"><code data-lang="http">DELETE /notes/delete/{id}</code></pre>
</div>
</div>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 50%;">
<col style="width: 50%;">
</colgroup>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">Response Code</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Description</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Successful response</p></td>
</tr>
</tbody>
</table>
</div>
</div>
</div>
</div>
<div id="footer">
<div id="footer-text">
</div>
</div>
</body>
</html>