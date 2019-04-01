function drop {
    echo "dropping db if exists..."
    mysql -uroot -proot -e "drop database if exists SolucionarAdmin"
    echo "-- done!"
}

function create {
    echo "creating db..."
    mysql -uroot -proot -e "create database SolucionarAdmin"
    echo "-- done!"
}

drop
echo ""
create