/* eslint-env es6 */
/* eslint-disable no-console */
const express = require('express');
const app = express();

const PORT = process.env.PORT || 4000;

app.use(express.static(__dirname + '/dist/nosso-cafe'));

app.get('/*', (req, res) => {
	res.sendFile(__dirname + '/dist/nosso-cafe/index.html')
})

app.listen(PORT, () => {
	console.log('Servidor iniciado com sucesso na porta: ' + PORT);
})
