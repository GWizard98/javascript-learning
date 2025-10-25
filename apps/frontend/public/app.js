const api = {
  java: () => fetch('/micro/java-hello').then(r => r.json()),
  micro: () => fetch('/micro/ping').then(r => r.json()),
};

const $ = (sel) => document.querySelector(sel);

$('#call-java').addEventListener('click', async () => {
  $('#java-out').textContent = 'Loading...';
  try {
    const data = await api.java();
    $('#java-out').textContent = JSON.stringify(data, null, 2);
  } catch (e) {
    $('#java-out').textContent = String(e);
  }
});

$('#call-micro').addEventListener('click', async () => {
  $('#micro-out').textContent = 'Loading...';
  try {
    const data = await api.micro();
    $('#micro-out').textContent = JSON.stringify(data, null, 2);
  } catch (e) {
    $('#micro-out').textContent = String(e);
  }
});
