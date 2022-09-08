<?php
if ($_GET) {
    echo '<pre>';
    echo htmlspecialchars(print_r($_GET, true));
    echo '</pre>';
}
?>