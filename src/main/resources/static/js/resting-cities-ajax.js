const xhr = new XMLHttpRequest()
xhr.onreadystatechange = function() {
	if (this.readyState === 4 && this.status === 200) {
		const res = JSON.parse(xhr.response);
		const container = document.querySelector('.container')

		res.forEach(function(state) {
			const eachState = document.createElement('div');
			const detailsList = document.createElement('ul');

			const name = document.createElement('h2');
			name.innerText = state.name;
			const abbr = document.createElement('li');
			abbr.innerText = `Abbreviation: ${state.abbreviation}`;
			const motto = document.createElement('li');
			motto.innerText = `Motto: ${state.motto}`;
			const fish = document.createElement('li');
			if (state.fish) {
				fish.innerText = `State Fish: ${state.fish.name}`;
			} else {
				fish.innerText = 'State Fish: none';
			}
			const citiesUrl = document.createElement('li');
			// const citiesLink = document.createElement('a');
			citiesUrl.innerHTML = `Cities URL: <a href="${state.citiesUrl}">${state.citiesUrl}</a>`;

			detailsList.appendChild(abbr);
			detailsList.appendChild(motto);
			detailsList.appendChild(fish);
			detailsList.appendChild(citiesUrl);

			eachState.appendChild(name);
			eachState.appendChild(detailsList);

			container.appendChild(eachState);
		})
	}
}

xhr.open('GET', 'http://localhost:8080/states', true)
xhr.send()