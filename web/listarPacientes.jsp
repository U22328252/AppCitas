<%@ page import="BusinessEntity.PacienteBE" %>
<%@ page import="BusinessLogic.PacienteBL" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    PacienteBL BL = new PacienteBL();
    String accion = request.getParameter("accion");
    String id = request.getParameter("id");

    if ("DELETE".equals(accion)) {
        BL.Eliminar(id);
    } else if ("UPDATE".equals(accion)) {
        PacienteBE p = new PacienteBE();
        p.setId_paciente(id);
        p.setIdentificador_externo(request.getParameter("identificadorExterno"));
        p.setNombre(request.getParameter("nombre"));
        p.setApellido(request.getParameter("apellido"));
        p.setFecha_nacimiento(java.sql.Date.valueOf(request.getParameter("fechaNacimiento")));
        p.setSexo(request.getParameter("sexo"));
        p.setDireccion(request.getParameter("direccion"));
        p.setTelefono(request.getParameter("telefono"));
        p.setCorreo(request.getParameter("correo"));
        BL.Actualizar(p);
    } else if ("NEW".equals(accion)) {
        PacienteBE p = new PacienteBE();
        p.setId_paciente(java.util.UUID.randomUUID().toString());
        p.setIdentificador_externo(request.getParameter("identificadorExterno"));
        p.setNombre(request.getParameter("nombre"));
        p.setApellido(request.getParameter("apellido"));
        p.setFecha_nacimiento(java.sql.Date.valueOf(request.getParameter("fechaNacimiento")));
        p.setSexo(request.getParameter("sexo"));
        p.setDireccion(request.getParameter("direccion"));
        p.setTelefono(request.getParameter("telefono"));
        p.setCorreo(request.getParameter("correo"));
        BL.Crear(p);
    }

    ArrayList<PacienteBE> Lst = BL.obtenerTodos();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Pacientes</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6">
    <div class="container mx-auto">
        <h1 class="text-2xl font-bold mb-4">Mantenimiento de Pacientes</h1>
        <a href="editarPaciente.jsp?accion=NEW" class="bg-blue-600 text-white px-4 py-2 rounded">Nuevo</a>
        <table class="min-w-full mt-4 bg-white border rounded shadow">
            <thead>
                <tr>
                    <th class="px-4 py-2">Acción</th>
                    <th class="px-4 py-2">Nombre</th>
                    <th class="px-4 py-2">Apellido</th>
                    <th class="px-4 py-2">Teléfono</th>
                    <th class="px-4 py-2">Correo</th>
                </tr>
            </thead>
            <tbody>
            <% for (PacienteBE p : Lst) { %>
                <tr>
                    <td class="px-4 py-2">
                        <a href="editarPaciente.jsp?accion=UPDATE&id=<%=p.getId_paciente()%>" class="text-blue-600 hover:underline">Editar</a> |
                        <a href="listarPacientes.jsp?accion=DELETE&id=<%=p.getId_paciente()%>" class="text-red-600 hover:underline" onclick="return confirm('¿Eliminar paciente?')">Eliminar</a>
                    </td>
                    <td class="px-4 py-2"><%=p.getNombre()%></td>
                    <td class="px-4 py-2"><%=p.getApellido()%></td>
                    <td class="px-4 py-2"><%=p.getTelefono()%></td>
                    <td class="px-4 py-2"><%=p.getCorreo()%></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
