<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.adanto.UserBean.*" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f9f9f9; margin: 0; padding: 0;}
        .header { text-align: right; padding: 15px 30px; background-color: #333; }
        .logout-btn {
            padding: 8px 16px;
            background: crimson;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
        }
        .logout-btn:hover {
            background: darkred;
        }
        h2 {
            text-align: center;
            margin-top: 30px;
            color: #333;
        }
        table {
            width: 80%;
            margin: 20px auto 40px auto;
            border-collapse: collapse;
            box-shadow: 0 0 8px #ccc;
            background: #fff;
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
            font-size: 16px;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        .rating {
            display: flex;
            justify-content: center;
            gap: 5px;
        }
        .star {
            font-size: 24px;
            cursor: pointer;
            color: gray;
            user-select: none;
            transition: color 0.2s ease-in-out;
        }
    </style>
</head>
<body>

<div class="header">
    <a href="jsp/logout.jsp" class="logout-btn">Logout</a>
</div>

<h2>Available Stores</h2>

<table>
    <tr>
        <th>Store Name</th>
        <th>Location</th>
        <th>Rate</th>
    </tr>

    <%
        List<storeBean> storeList = (List<storeBean>)request.getAttribute("storeList");
        if (storeList != null && !storeList.isEmpty()) {
            for (storeBean s : storeList) {
    %>
    <tr>
        <td><%= s.getName() %></td>
        <td><%= s.getLocation() %></td>
        <td class="rating">
            <% for (int i = 1; i <= 5; i++) { %>
                <a href="RateStoreServlet?storeId=<%= s.getId() %>&rating=<%= i %>" class="star">&#9733;</a>
            <% } %>
        </td>
    </tr>
    <% 
            }
        } else { 
    %>
    <tr>
        <td colspan="3">No stores found</td>
    </tr>
    <% } %>
</table>

<script>
document.addEventListener('DOMContentLoaded', () => {
  const ratingCells = document.querySelectorAll('.rating');

  ratingCells.forEach(cell => {
    const stars = cell.querySelectorAll('.star');
    let selectedRating = 0;

    stars.forEach((star, idx) => {
      star.addEventListener('mouseover', () => {
        highlightStars(stars, idx + 1);
      });
      star.addEventListener('mouseout', () => {
        highlightStars(stars, selectedRating);
      });
      star.addEventListener('click', (e) => {
        e.preventDefault(); // stop immediate navigation to show star highlight

        selectedRating = idx + 1;
        highlightStars(stars, selectedRating);

        // Navigate after star highlight
        window.location.href = star.href;
      });
    });
  });

  function highlightStars(stars, rating) {
    stars.forEach((star, index) => {
      star.style.color = (index < rating) ? 'gold' : 'gray';
    });
  }
});
</script>

</body>
</html>
