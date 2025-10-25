const inp = document.querySelector('#inp');
const out = document.querySelector('#out');
const btn = document.querySelector('#reflect');
const link = document.querySelector('#server-link');

function renderUnsafe(html) {
  // WARNING: intentionally unsafe for the lab
  out.innerHTML = `<div class="box">${html}</div>`;
}

btn.addEventListener('click', () => {
  renderUnsafe(inp.value);
});

link.addEventListener('click', (e) => {
  e.preventDefault();
  const url = `/xss/echo?text=${encodeURIComponent(inp.value)}`;
  window.open(url, '_blank');
});
