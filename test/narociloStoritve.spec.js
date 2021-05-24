describe('Dodajanje narocila', function () {
    it('Dodaj narocilo za storitev', function () {
        cy.visit('http://localhost:4200/login')

        cy.url()
            .should('include', '/login')

        cy.get('.email')
            .type('lastničko')
            .should('have.value', 'lastničko')

        cy.get('.password')
            .type('lastnik')
            .should('have.value', 'lastnik')

        cy.get('.btn-primary')
            .click()
        cy.wait(500)



        cy.get('select').select('Car1')
        cy.get('.btn').contains('Naroči')
            .click()

        cy.get('a').contains('Profil')
            .click()
        cy.wait(500)



        cy.get('.btn').contains(' Dodaj novega psa ')
            .click()

        cy.get('h1').contains('Dodaj psa')

        cy.get('input[name="ime"]')
            .type('Car')
            .should('have.value', 'Car')

        cy.get('input[name="pasma"]')
            .type('carska')
            .should('have.value', 'carska')

        cy.get('textarea[name="komentarji"]')
            .type('Udomačena psica')
            .should('have.value', 'Udomačena psica')

        cy.get('.btn')
            .contains('Dodaj štirinožca')
            .click()

        cy.wait(500)

        cy.get('a').contains('Profil')
            .click()

        cy.get('h2').contains('Car')
    });
});
