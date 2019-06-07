/**
 * 
 */
$('#editAirline').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var id = button.data('id')
  var name = button.data('name')
  var status = button.data('status')
  // Extract info from data-* attributes
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  if (status==true) {
	  document.getElementById("optionActive").selected = true
  } else {
	  document.getElementById("optionInactive").selected = true
  }
  var modal = $(this)
  modal.find('.modal-title').text('Edit airline ' + name)
  modal.find('#airline-name').val(name)
  modal.find('#airline-id').val(id)
})