const xhr = new XMLHttpRequest()
xhr.onreadystatechange = function() {
	if (this.readyState === 4 && this.status === 200) {
		const res = JSON.parse(xhr.response);

		console.log(res)
		const body = document.body;

		res.forEach(function(state) {
			const list = document.createElement('ul');
			const name = document.createElement('li');
			name.innerText = state.name;
			const abbr = document.createElement('li');
			abbr.innerText = state.abbreviation;
			list.appendChild(name);
			list.appendChild(abbr);
			body.appendChild.list;
		})

		// const courseContainer = document.createElement('div')
		// courseContainer.classList.add('courseContainer')

		// const courseTitle = createElement('h2', res[0].name)
		// const courseDescription = createElement('p', res[0].description)
		// const courseInstructor = createElement('h3', res[0].instructor.name)

		// appendElement(courseContainer, courseTitle)
		// appendElement(courseContainer, courseDescription)
		// appendElement(courseContainer, courseInstructor)

		// appendElement(body, courseContainer)

		// function createElement(elem, textValue) {
		// 	const newElem = document.createElement(elem)
		// 	newElem.innerText = textValue
		// 	return newElem
		// }

		// function appendElement(parent, child) {
		// 	parent.appendChild(child)
		// }
	}
}

xhr.open('GET', 'http://localhost:8080/states', true)
xhr.send()