const express = require('express');
const PORT = process.env.PORT || 3000;

const app = express();

let isBeingEdited = false;

app.use('/', express.static('./public/'));
app.use('/', express.static('./node_modules/'));

app.post('/edit', (req, res) => {
  isBeingEdited = true;

  let obj = fs.readFile('./public/data.json', 'utf8');
  console.log
});

app.listen(PORT, () => {
  console.log(`Now listening on port ${PORT}`);
});
