<c:if test="${not empty msg }">
  <div class="alert alert-success">${msg}</div>
</c:if>
<c:if test="${not empty error}">
  <div class="alert alert-error">${error}</div>
</c:if>