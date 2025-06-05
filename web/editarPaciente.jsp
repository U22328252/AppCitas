<%@ page import="BusinessEntity.PacienteBE" %>
<%@ page import="BusinessLogic.PacienteBL" %>
<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String accion = request.getParameter("accion");
    String id = request.getParameter("id");
    PacienteBE p = new PacienteBE();

    if ("UPDATE".equals(accion)) {
        PacienteBL BL = new PacienteBL();
        p = BL.obtenerPorId(id);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title><%=accion.equals("NEW") ? "Nuevo" : "Editar"%> Paciente</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6">
    <div class="container mx-auto">
        <h1 class="text-2xl font-bold mb-4"><%=accion.equals("NEW") ? "Registrar" : "Actualizar"%> Paciente</h1>
        <form action="listarPacientes.jsp" method="post" class="bg-white p-6 rounded shadow-md">
            <input type="hidden" name="accion" value="<%=accion%>">
            <% if ("UPDATE".equals(accion)) { %>
                <input type="hidden" name="id" value="<%=p.getId_paciente()%>">
            <% } %>
            <input name="identificadorExterno" value="<%=p.getIdentificador_externo()!= null ? p.getIdentificador_externo(): ""%>" placeholder="Identificador Externo" class="w-full mb-2 p-2 border rounded" required>
            <input name="nombre" value="<%=p.getNombre() != null ? p.getNombre() : ""%>" placeholder="Nombre" class="w-full mb-2 p-2 border rounded" required>
            <input name="apellido" value="<%=p.getApellido() != null ? p.getApellido() : ""%>" placeholder="Apellido" class="w-full mb-2 p-2 border rounded" required>
            <input name="fechaNacimiento" type="date" value="<%=p.getFecha_nacimiento()!= null ? p.getFecha_nacimiento().toString() : ""%>" class="w-full mb-2 p-2 border rounded" required>
            <select name="sexo" class="w-full mb-2 p-2 border rounded">
                <option value="male" <%= "M".equals(p.getSexo()) ? "selected" : "" %>>Masculino</option>
                <option value="female" <%= "F".equals(p.getSexo()) ? "selected" : "" %>>Femenino</option>
                <option value="other" <%= "O".equals(p.getSexo()) ? "selected" : "" %>>Otro</option>
            </select>
            <textarea name="direccion" placeholder="Dirección" class="w-full mb-2 p-2 border rounded"><%=p.getDireccion() != null ? p.getDireccion() : ""%></textarea>
            <input name="telefono" value="<%=p.getTelefono() != null ? p.getTelefono() : ""%>" placeholder="Teléfono" class="w-full mb-2 p-2 border rounded">
            <input name="correo" value="<%=p.getCorreo() != null ? p.getCorreo() : ""%>" placeholder="Correo Electrónico" class="w-full mb-4 p-2 border rounded">
            <button type="submit" class="bg-green-600 text-white py-2 px-4 rounded"><%=accion.equals("NEW") ? "Registrar" : "Actualizar"%></button>
            <a href="listarPacientes.jsp" class="ml-4 text-gray-600 underline">Cancelar</a>
        </form>
    </div>
</body>
</html>
