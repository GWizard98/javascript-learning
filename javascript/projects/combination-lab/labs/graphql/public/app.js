const out = document.querySelector('#out');
const nameInp = document.querySelector('#name');
const btn = document.querySelector('#run');

const GQL_URL = 'http://localhost:8080/graphql';

btn.addEventListener('click', async () => {
  out.textContent = 'Loading...';
  const name = nameInp.value.trim() || null;
  const query = `query($name: String){ helloGraph(name: $name) { message from language } }`;
  try {
    const res = await fetch(GQL_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ query, variables: { name } })
    });
    const data = await res.json();
    out.textContent = JSON.stringify(data, null, 2);
  } catch (e) {
    out.textContent = String(e);
  }
});
