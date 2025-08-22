create table if not exists dungeon_game(
    id uuid not null primary key default gen_random_uuid(),
    minimal_health integer not null,
	execution_id text not null
);

create index if not exists idx_game_execution_id on dungeon_game(execution_id);